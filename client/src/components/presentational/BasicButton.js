import React from 'react'
import styled from 'styled-components'

const LoginButton = styled.button`
  border-radius: 10px;
`

const BasicButton = props => {

    const {message = 'default', onClick} = props


    return (
        <LoginButton onClick={onClick}>{message}</LoginButton>
    )
}

export default BasicButton