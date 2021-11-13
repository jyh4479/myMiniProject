import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {HomePage, LoginPage, MyPage, SignUpPage} from "./pages";
import {PrivateRoute} from "./utils";

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
                <PrivateRoute exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
                <PrivateRoute path={'/mypage'} component={MyPage}/>
            </Switch>
        </Router>
    );
}

export default App;
