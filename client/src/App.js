import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {ChatAppPage, FriendListPage, HomePage, LoginPage, MyPage, SignUpPage} from "./pages";
import {PrivateRoute} from "./utils";
import ChatRoomPage from "./pages/ChatRoomPage";
import {GlobalNavigationBar} from "./components/presentational";

const App = props => {

    console.log(window.localStorage.getItem('access-token'))
    console.log(window.location.pathname)

    return (
        <Router>
            {/*<Route render={() => (*/}
            {/*    <Redirect to={*/}
            {/*        '/login'*/}
            {/*        // window.localStorage.getItem('access-token') === null ? '/login' : window.location.pathname*/}
            {/*        //window.location.pathname === '/' ? '/login' : '/'*/}
            {/*    }/>)}/>*/}
            <GlobalNavigationBar/>
            <Switch>
                <Route exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
                <PrivateRoute path={'/mypage'} component={MyPage}/>
                <PrivateRoute path={'/friends'} component={FriendListPage}/>
                <PrivateRoute path={'/chat'} component={ChatAppPage}/>
                <PrivateRoute path={'/chatroom/:roomId'} component={ChatRoomPage}/>
            </Switch>
        </Router>
    );
}

export default App;
