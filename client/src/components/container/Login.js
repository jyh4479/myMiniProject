import React, {useState} from 'react'
import {BasicButton, BasicText, ComponentBox, Row} from '../presentational'
import apiService from '../../utils/API'
import '../../styles/Login.scss'

const Login = props => {

    const [memberCheck, setMemberCheck] = useState(false);

    let getInputId = React.createRef()
    let getInputPassword = React.createRef()

    const signIn = async (e) => {
        e.preventDefault()
        const id = getInputId.current.value
        const password = getInputPassword.current.value
        console.log(await apiService.signIn(id, password))
        // setMemberCheck(!result)
    }

    const signUp = e => {
        e.preventDefault()
        props.history.push('/signup')
    }

    return (
        <>

            <Row>
                <ComponentBox width={400} height={400}>

                    <BasicText type={'title'} message={'Welcome PangPang Study Planner!'}/>
                    <Row><input className={'loginInput'} placeholder={'ID'} ref={getInputId}/></Row>
                    <Row><input className={'loginInput'} placeholder={'PASSWORD'} type={'password'}
                                ref={getInputPassword}/></Row>
                    <Row>
                        <BasicButton message={'로그인'} onClick={signIn}/>
                        <BasicButton message={'회원가입'} onClick={signUp}/>
                    </Row>

                    <Row visible={memberCheck} marginTop={15}><BasicText type={'content'}
                                                                         message={'아이디와 비밀번호를 확인해주세요.'}/></Row>

                </ComponentBox>
            </Row>
        </>
    )
}

export default Login