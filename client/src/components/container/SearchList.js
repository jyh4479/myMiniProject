import React, {useEffect, useState} from 'react'
import {memberServiceApi} from "../../utils";
import {ToolTip} from "../presentational";
import "../../styles/SearchList.scss"

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
                <ToolTip id={item.id} message="친구추가" onClick={() => addFriend(memberId, item.id)} direction="right">
                    <div id={item.id} className={'searchList'}>{item.name}</div>
                </ToolTip>
            )
        })
        return view
    }

    return (
        <>
            {allMemberList !== null ? (
                <div className={'searchListContainer'}> {makeListView(allMemberList)} </div>
            ) : (
                <div> List가 없습니다. </div>
            )}
        </>
    )
}
export default SearchList
