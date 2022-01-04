import React, {useEffect, useState} from 'react'
import {memberServiceApi} from '../../utils'
import {BasicButton, GlobalNavigationBar, Row} from "../presentational";

const Home = props => {

    const [loginState, setLoginState] = useState(false)
    const [memberId, setMemberId] = useState(null)

    useEffect(() => {
        if (memberServiceApi.isToken()) {
            setLoginState(true)
            setMemberId(memberServiceApi.getMemberId())
        }
    }, [])

    const signIn = e => {
        e.preventDefault()
        props.history.push('/login')
    }

    const logOut = e => {
        e.preventDefault()
        window.localStorage.removeItem('access-token')
        props.history.push('/login')
    }

    return (
        <>
            {/*<GlobalNavigationBar history={props.history}/>*/}
            <Row>
                {loginState ? <div>{memberId}님 환영합니다.</div> :
                    <BasicButton type={'login'} message={'로그인'} onClick={signIn}/>}
            </Row>
            <Row>
                <div>홈</div>
            </Row>
            <Row><BasicButton message={'로그아웃'} onClick={logOut}/></Row>
        </>
    )
}

export default Home