import React, {useMemo} from 'react'
import {BasicButton, Row} from '../presentational'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faWindowClose} from '@fortawesome/free-regular-svg-icons'
import {faComments, faSearch, faUser, faUsers} from '@fortawesome/free-solid-svg-icons'
import '../../styles/GlobalNavigationBar.scss'

import {Link} from 'react-router-dom'


const GlobalNavigationBar = () => {

    //임시적으로 채팅방에서는 GNB 보이지 않게하기 위한 로직 --> 나중에 채팅방 app 자체를 따로 생성하는게 맞다고 생각
    const path = window.location.href
    if (path.includes("chatroom")) return null

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

    // eslint-disable-next-line react-hooks/rules-of-hooks
    const MenuView = useMemo(() => {
        const iconInfo = [[faUser, '/mypage'], [faUsers, '/friends'], [faComments, '/chat'], [faSearch, '/search'], [faWindowClose, '/']]
        return makeMenuView(iconInfo)
    }, [])

    return (
        <Row rowGap={30} className={'globalMenu'}>
            {MenuView}
        </Row>
    )
}

export default GlobalNavigationBar