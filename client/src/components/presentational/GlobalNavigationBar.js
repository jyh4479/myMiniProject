import React, {useMemo} from 'react'
import {BasicButton, Row} from '../presentational'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faComments, faUser, faWindowClose} from '@fortawesome/free-regular-svg-icons'
import '../../styles/GlobalNavigationBar.scss'


const GlobalNavigationBar = props => {

    const makeMenuView = itemList => {
        return itemList.map(icon =>
            <BasicButton type={'menu'} className={'globalMenuButton'}><FontAwesomeIcon
                onClick={() => {
                    props.history.push(icon[1])
                }}
                icon={icon[0]}
                size={"2x"}/></BasicButton>
        )
    }
    const MenuView = useMemo(() => {
        const iconInfo = [[faUser, '/mypage'], [faComments, '/'], [faWindowClose, '/'], [faWindowClose, '/'], [faWindowClose, '/']]
        return makeMenuView(iconInfo)
    }, [])

    return (
        <Row rowGap={30} className={'globalMenu'}>
            {MenuView}
        </Row>
    )
}

export default GlobalNavigationBar