import React, {useMemo} from 'react'
import {BasicButton, Row} from '../presentational'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faWindowClose} from '@fortawesome/free-regular-svg-icons'
import {faComments, faUser, faUsers} from '@fortawesome/free-solid-svg-icons'
import '../../styles/GlobalNavigationBar.scss'

import {Link} from 'react-router-dom'


const GlobalNavigationBar = () => {

    const makeMenuView = itemList => {
        return itemList.map(icon =>
                <Link to={icon[1]}>
                    <BasicButton type={'menu'} className={'globalMenuButton'}>
                        <FontAwesomeIcon
                            icon={icon[0]}
                            size={"2x"}/></BasicButton>
                </Link>

            // <BasicButton type={'menu'} className={'globalMenuButton'}><FontAwesomeIcon
            //     onClick={() => {
            //         props.history.push(icon[1])
            //     }}
            //     icon={icon[0]}
            //     size={"2x"}/></BasicButton>
        )
    }
    const MenuView = useMemo(() => {
        const iconInfo = [[faUser, '/mypage'], [faUsers, '/friends'], [faComments, '/chat'], [faWindowClose, '/'], [faWindowClose, '/']]
        return makeMenuView(iconInfo)
    }, [])

    return (
        <Row rowGap={30} className={'globalMenu'}>
            {MenuView}
        </Row>
    )
}

export default GlobalNavigationBar