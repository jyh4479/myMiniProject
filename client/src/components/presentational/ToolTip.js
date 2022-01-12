import React from 'react'
import '../../styles/ToolTip.scss'

const ToolTip = props => {
    //https://www.daleseo.com/css-position-absolute-tooltip/

    const {children, message, onClick} = props
    // const [mouseX, setMouseX] = useState(0)
    // const toolTipLocation = useRef()
    //
    //
    // document.onmousemove = e => {
    //     toolTipLocation.current.style = `left:${e.pageX-20}px;`
    //     // setMouseX(e.pageX)
    //     // console.log(e.pageX);
    // }

    // useEffect(() => {
    //     toolTipLocation.current.style = `left:${mouseX}px`
    //
    // }, [mouseX])

    // const toolTipStyle={
    //
    // }
    // toolTipLocation.current.style


    // const content = document.getElementById("content");
    // document.onmousemove = (e) => {
    //     content.style.left = e.pageX + "px";
    //     content.style.top = e.pageY + "px";
    // }

    return (
        <div className={'container'}>
            {children}
            <button className={'content boxFade'} onClick={onClick}>{message}</button>
        </div>
    )
}

export default ToolTip