import React from 'react'
import {BasicButton, BasicText, ComponentBox, Row} from '../presentational'
import apiService from '../../utils/API'
import '../../styles/Login.scss'

const Login = props => {
    let getInputId = React.createRef()
    let getInputPassword = React.createRef()

    const signIn = async (e) => {
        e.preventDefault()
        const id = getInputId.current.value
        const password = getInputPassword.current.value
        await apiService.signIn(id, password)
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
                    <Row marginTop={15} rowGap={10}>
                        <BasicButton message={'로그인'} onClick={signIn}/>
                        <BasicButton message={'회원가입'} onClick={signUp}/>
                    </Row>

                </ComponentBox>
            </Row>
        </>
    )
}

export default Login