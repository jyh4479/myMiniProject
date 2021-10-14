import React from 'react';
import apiService from '../../utils/API'
import {BasicButton, BasicText, ComponentBox, Row} from '../presentational';

const SignUp = () => {
    let getInputId = React.createRef()
    let getInputPassword = React.createRef()
    let getInputName = React.createRef()
    let getInputEmail = React.createRef()

    const signUp = async (e) => {
        const id = getInputId.current.value
        const password = getInputPassword.current.value
        const name = getInputName.current.value
        const email = getInputEmail.current.value
        await apiService.signUp(id, password, name, email)
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
                    {/*<BasicButton message={'로그인'} onClick={signIn}/>*/}
                    <BasicButton message={'회원가입'} onClick={signUp}/>
                </Row>

            </ComponentBox>
        </Row>
    )
}

export default SignUp