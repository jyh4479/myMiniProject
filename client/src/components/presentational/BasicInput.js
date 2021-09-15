import React from 'react'
import styled from 'styled-components'

const BasicInput = props => {

    const {message = 'default', onChange = value =>console.log('empty')} = props

    const LoginInput = styled.input`
      width: 150px;
      height: 20px;
      border-radius: 10px;
    `

    const thisOnChange = e => {
        onChange(e.target.value)
    }

    return <LoginInput placeholder={message} onChange={thisOnChange}/>
}

export default BasicInput