import React, {useEffect, useState} from 'react'
import {memberServiceApi} from "../../utils";
import {ToolTip} from "../presentational";

const SearchList = props => {

    const memberId = memberServiceApi.getMemberId()
    const [allMemberList, setAllMemberList] = useState([])

    useEffect(() => {
        fetchData().then(r => {
            console.log("run fetchData")
        })
    }, [memberId])

    const fetchData = async () => {
        const memberList = await memberServiceApi.getMembersData()
        setAllMemberList(memberList)
    }

    const addFriend = (myId, friendId) => {
        memberServiceApi.addFriend(myId, friendId).then(r => {
            console.log("run add data")
        })
    }

    const makeListView = memberList => {
        const view = []
        memberList.forEach(item => {
            if (item.id !== memberId) view.push(
                <ToolTip message="친구추가" onClick={() => addFriend(memberId, item.id)} direction="right">
                    <div className={'friendList'}>{item.id}</div>
                </ToolTip>
            )
        })
        return view
    }

    return (
        <>
            {allMemberList !== null ? (
                <div> {makeListView(allMemberList)} </div>
            ) : (
                <div> List가 없습니다. </div>
            )}
        </>
    )
}
export default SearchList
