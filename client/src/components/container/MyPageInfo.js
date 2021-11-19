import React, {useEffect, useState} from 'react'
import {memberServiceApi} from '../../utils'

const MyPageInfo = props => {

    const memberId = memberServiceApi.getMemberId()
    const [viewMemberId, setViewMemberId] = useState()
    const [viewMemberName, setViewMemberName] = useState()
    const [viewMemberEmail, setViewMemberEmail] = useState()

    const fetchData = async (memberId) => {
        const {id, name, email} = await memberServiceApi.getMemberData(memberId)
        setViewMemberId(id)
        setViewMemberName(name)
        setViewMemberEmail(email)
    }

    useEffect(() => {
        fetchData(memberId).then(r => {
            console.log("run fetchData")
        })
    }, [memberId])

    return (
        <>
            <div>{viewMemberId}</div>
            <div>{viewMemberName}</div>
            <div>{viewMemberEmail}</div>
        </>
    )
}

export default MyPageInfo