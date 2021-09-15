import React from 'react'
import styled from 'styled-components'

const Title = styled.h3`
  text-align: center;
`
const Content = styled.div`
  text-align: center;
`

const BasicText = props => {

    const {message = 'default', type = 'content'} = props

    return (
        <>
            {type === 'title'
                ? <Title>{message}</Title>
                : <Content>{message}</Content>
            }
        </>
    )
}

export default BasicText