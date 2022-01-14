import React from 'react'
import styled from 'styled-components'

const DefaultButton = styled.button`
  border-radius: 10px;
`
const LoginButton = styled.button`
  border: 0;
  outline: 0;
  cursor: pointer;
  background: darkslategrey;
  color:lightgoldenrodyellow;
`

const MenuButton = styled.button`
  border: 0;
  outline: 0;
  cursor: pointer;
  background: none;
`

const BasicButton = props => {

    const {type = '', message = '', onClick = '', children, className,id} = props

    if (type === 'login') return <LoginButton id={id} className={className} onClick={onClick}>{message} {children} </LoginButton>
    else if (type === 'menu') return <MenuButton id={id} className={className} onClick={onClick}>{message} {children} </MenuButton>
    else return <DefaultButton id={id} className={className} onClick={onClick}>{message} {children}</DefaultButton>
}

export default BasicButton