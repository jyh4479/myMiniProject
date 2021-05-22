import React from 'react'
import apiService from '../../utils/API'
import {BasicButton, Row} from "../presentational";

const Home = props => {

    const {userId} = apiService.getUserData(window.localStorage.getItem('access-token'))

    const logOut = e => {
        e.preventDefault()
        window.localStorage.removeItem('access-token')
        props.history.push('/login')
        console.log('로그아웃동작')
    }

    return (
        <>
            <Row>
                <div>{userId}님 환영합니다.</div>
                <div>홈</div>
            </Row>
            <Row><BasicButton message={'로그아웃'} onClick={logOut}/></Row>
        </>
    )
}

export default Home