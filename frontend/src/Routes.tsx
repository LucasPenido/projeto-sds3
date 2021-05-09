import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Home from 'pages/Home';
import DashBoard from 'pages/DashBoard';

function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path='/' exact>
          <Home />
        </Route>
        <Route path='/dashboard'>
          <DashBoard />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
