import React from 'react'
import {BasicButton, Row} from '../presentational'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
// import {faComments, faUserAlt} from '@fortawesome/free-solid-svg-icons'
import {faComments, faUser} from '@fortawesome/free-regular-svg-icons'


const GlobalNavigationBar = () => {
    return (
        <>
            <Row>
                <BasicButton type={'menu'}><FontAwesomeIcon icon={faUser}/></BasicButton>
                <BasicButton type={'menu'}><FontAwesomeIcon icon={faComments}/></BasicButton>
            </Row>
            <Row>
                <div>Bar</div>
            </Row>
        </>
    )
}

export default GlobalNavigationBar