import React from 'react'
import '../../styles/ToolTip.scss'

const ToolTip = ({children, message}) => {

    //https://www.daleseo.com/css-position-absolute-tooltip/

    return (
        <div className={'container'}>
            {children}
            <button className={'content boxFade'}>{message}</button>
        </div>
    )
}

export default ToolTip