import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {HomePage, LoginPage, SignUpPage} from "./pages";

function App() {
    return (
        <Router>
            <Switch>
                <Route exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
            </Switch>
        </Router>
    );
}

export default App;
