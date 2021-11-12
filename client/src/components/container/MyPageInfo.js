import React, {useEffect} from 'react'
import {memberServiceApi} from '../../utils'

const MyPageInfo = props => {

    const memberId = memberServiceApi.getMemberId()
    const memberData = memberServiceApi.getMemberData(memberId)

    useEffect(() => {

    }, [])

    return (
        <div>MyPage</div>
    )
}

export default MyPageInfo