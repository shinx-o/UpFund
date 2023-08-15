import { Route, Routes } from 'react-router-dom';
import './App.scss';
import CreateMutualFund from './components/Manager/CreateMutualFund';
import Home from './components/Home/Home';
import ManagerDashBoard from './components/Manager/ManagerDashBoard';
import NavBar from './components/NavBar/NavBar';
import InvestorDashboard from './components/Investor/InvestorDashboard';


function App() {
  return (
    <div className="App">
      <NavBar />
      <Routes>
        <Route path='*' element={<Home />} />
        <Route path='/managerDashboard' element={<ManagerDashBoard />} />
        <Route path='/createMutualFund' element={<CreateMutualFund />} />
        <Route path='/investorDashboard' element={<InvestorDashboard />} />
      </Routes>

    </div>
  );
}

export default App;
