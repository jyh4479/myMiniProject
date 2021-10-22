import React from 'react'
import styled from 'styled-components'

const Row = props => {

    const {
        marginTop = 0,
        marginLeft = 0,
        marginBottom = 0,
        marginRight = 0,
        columnGap = 0,
        rowGap = 0,
        visible = true,
        className
    } = props

    const BasicRow = styled.div`
      display: ${visible ? "flex" : "none"};
      justify-content: center;
      width: 100%;
      margin: ${marginTop}px ${marginLeft}px ${marginBottom}px ${marginRight}px;
      gap: ${columnGap}px ${rowGap}px;
    `

    return (
        <BasicRow className={className}>
            {props.children}
        </BasicRow>
    )
}

export default Row