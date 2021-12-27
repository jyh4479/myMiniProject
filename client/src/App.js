import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {ChatAppPage, HomePage, LoginPage, MyPage, SignUpPage} from "./pages";
import {PrivateRoute} from "./utils";
import ChatRoomPage from "./pages/ChatRoomPage";

const App = () => {

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
            <Switch>
                <Route exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
                <PrivateRoute path={'/mypage'} component={MyPage}/>
                <PrivateRoute path={'/chat'} component={ChatAppPage}/>
                <PrivateRoute path={'/chatroom'} component={ChatRoomPage}></PrivateRoute>
            </Switch>
        </Router>
    );
}

export default App;
