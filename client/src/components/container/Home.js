import React from 'react'
import {BasicButton, Row} from "../presentational";

const Home = props => {

    const logOut = e => {
        e.preventDefault()
        window.localStorage.removeItem('access-token')
        props.history.push('/login')
        console.log('로그아웃동작')
    }

    return (
        <>
            <Row>
                <div>홈</div>
            </Row>
            <Row><BasicButton message={'로그아웃'} onClick={logOut}/></Row>
        </>
    )
}

export default Home