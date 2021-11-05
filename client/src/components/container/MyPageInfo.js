import React, {useEffect} from 'react'
import apiService from '../../utils/API'

const MyPageInfo = props => {

    const userId = apiService.getUserId()
    const userData = apiService.getUserData(userId)

    useEffect(() => {

    }, [])

    return (
        <div>MyPage</div>
    )
}

export default MyPageInfo