import React, {useMemo} from 'react'
import {BasicButton, Row} from '../presentational'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faComments, faUser, faWindowClose} from '@fortawesome/free-regular-svg-icons'
import '../../styles/GlobalNavigationBar.scss'


const GlobalNavigationBar = () => {

    const makeMenuView = (itemList) => {
        return itemList.map(icon => <BasicButton type={'menu'} className={'globalMenuButton'}><FontAwesomeIcon
            icon={icon}
            size={"2x"}/></BasicButton>)
    }
    const MenuView = useMemo(() => {
        const icons = [faUser, faComments, faWindowClose, faWindowClose, faWindowClose]
        return makeMenuView(icons)
    }, [])

    return (
        <>
            <Row rowGap={30}>
                {MenuView}
            </Row>
            <Row>
                <div>Bar</div>
            </Row>
        </>
    )
}

export default GlobalNavigationBar