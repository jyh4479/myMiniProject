import React from 'react'
import styled from 'styled-components'

const Row = props => {

    const {marginTop, marginLeft, marginBottom, marginRight, columnGap, rowGap} = props

    const BasicRow = styled.div`
    display:flex;
    justify-content: center;
    width: 100%;
    margin: ${marginTop}px ${marginLeft}px ${marginBottom}px ${marginRight}px;
    gap: ${columnGap}px ${rowGap}px;
    `

    return (
        <BasicRow>
            {props.children}
        </BasicRow>
    )
}

export default Row