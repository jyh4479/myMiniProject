import React, {useState} from 'react'
import {BasicText, Row} from '../presentational'
import {authServiceApi} from '../../utils'
import '../../styles/Login.scss'

import 'bootstrap/dist/css/bootstrap.min.css'
import {Button, Form, FormGroup} from 'react-bootstrap'

const Login = props => {

    const [memberCheck, setMemberCheck] = useState(false);

    let getInputId = React.createRef()
    let getInputPassword = React.createRef()

    const signIn = async (e) => {
        e.preventDefault()

        const id = getInputId.current.value
        const password = getInputPassword.current.value

        let result

        try {
            result = await authServiceApi.signIn(id, password)
            props.history.push('/')
        } catch (e) {
            console.log('Error Catch in Login')
            console.log(e)
        } finally {
            setMemberCheck(!result)
        }

    }

    const signUp = e => {
        e.preventDefault()
        props.history.push('/signup')
    }

    return (
        <>

            <Row>
                {/*<ComponentBox width={400} height={400}>*/}
                <Form className={'mb-3'}>

                    <BasicText type={'title'} message={'Welcome PangPang Study Planner!'}/>

                    <FormGroup>
                        <label>ID</label>
                        <input className={'form-control'} placeholder={'ID'} ref={getInputId}/>
                    </FormGroup>
                    <FormGroup>
                        <label>Password</label>
                        <input className={'form-control'} placeholder={'Password'} type={'password'}
                               ref={getInputPassword}/>
                    </FormGroup>

                    <Row>
                        <Button onClick={signIn}>로그인</Button>
                        <Button onClick={signUp}>회원가입</Button>
                    </Row>

                    <Row className={'error'} visible={memberCheck} marginTop={15}><BasicText type={'content'}
                                                                                             message={'아이디와 비밀번호를 확인해주세요.'}/></Row>
                </Form>
                {/*</ComponentBox>*/}
            </Row>
        </>
    )
}

export default Login