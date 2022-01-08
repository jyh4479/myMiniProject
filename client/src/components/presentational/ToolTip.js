import React from 'react'
import '../../styles/ToolTip.scss'

const ToolTip = props => {
    //https://www.daleseo.com/css-position-absolute-tooltip/

    const {children, message, onClick} = props

    return (
        <div className={'container'}>
            {children}
            <button className={'content boxFade'} onClick={onClick}>{message}</button>
        </div>
    )
}

export default ToolTip