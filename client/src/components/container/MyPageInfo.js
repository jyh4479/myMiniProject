import React, {useEffect, useState} from 'react'
import {memberServiceApi} from '../../utils'

const MyPageInfo = props => {

    const memberId = memberServiceApi.getMemberId()
    const [viewMemberId, setViewMemberId] = useState()

    const fetchData = async (memberId) => {
        const {id} = await memberServiceApi.getMemberData(memberId)
        setViewMemberId(id)
    }

    useEffect(() => {
        fetchData(memberId)
    }, [memberId])

    return (
        <div>{viewMemberId}</div>
    )
}

export default MyPageInfo