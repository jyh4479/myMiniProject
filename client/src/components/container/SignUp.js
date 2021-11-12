import React from 'react';
import {authServiceApi} from '../../utils'
import {BasicButton, BasicText, ComponentBox, Row} from '../presentational';

const SignUp = props => {
    let getInputId = React.createRef()
    let getInputPassword = React.createRef()
    let getInputName = React.createRef()
    let getInputEmail = React.createRef()

    const signUp = async (e) => {
        const id = getInputId.current.value
        const password = getInputPassword.current.value
        const name = getInputName.current.value
        const email = getInputEmail.current.value
        await authServiceApi.signUp(id, password, name, email)
    }

    const back = e => {
        e.preventDefault()
        props.history.push('/login')
    }

    return (
        <Row>
            <ComponentBox width={400} height={400}>
                <BasicText type={'title'} message={'SignUp!'}/>
                <Row><input placeholder={'아이디'} ref={getInputId}/></Row>
                <Row><input placeholder={'비밀번호'} type={'password'} ref={getInputPassword}/></Row>
                <Row><input placeholder={'비밀번호 확인'}/></Row>
                <Row><input placeholder={'이름'} ref={getInputName}/></Row>
                <Row><input placeholder={'생년월일'}/></Row>
                <Row><input placeholder={'전화번호'}/></Row>
                <Row><input placeholder={'이메일'} ref={getInputEmail}/></Row>

                <Row marginTop={15} rowGap={10}>
                    <BasicButton message={'회원가입'} onClick={signUp}/>
                    <BasicButton message={'뒤로가기'} onClick={back}/>
                </Row>

            </ComponentBox>
        </Row>
    )
}

export default SignUp