import React from 'react'
import {memberServiceApi} from '../../utils'
import {BasicButton, GlobalNavigationBar, Row} from "../presentational";

const Home = props => {

    const memberId = memberServiceApi.getMemberId()

    const logOut = e => {
        e.preventDefault()
        window.localStorage.removeItem('access-token')
        props.history.push('/login')
        console.log('로그아웃동작')
    }

    return (
        <>
            <GlobalNavigationBar history={props.history}/>
            <Row>
                <div>{memberId}님 환영합니다.</div>
            </Row>
            <Row>
                <div>홈</div>
            </Row>
            <Row><BasicButton message={'로그아웃'} onClick={logOut}/></Row>
        </>
    )
}

export default Home