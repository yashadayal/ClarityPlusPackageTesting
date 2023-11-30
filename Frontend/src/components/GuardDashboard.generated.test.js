import renderer from 'react-test-renderer';
import React from "react";
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Avatar from '@mui/material/Avatar';
import SearchIcon from '@mui/icons-material/Search';
import GuardDashboard from "./GuardDashboard";

jest.mock('@mui/material/AppBar');
jest.mock('@mui/material/Toolbar');
jest.mock('@mui/material/Avatar');
jest.mock('@mui/icons-material/Search');

const renderTree = tree => renderer.create(tree);
describe('<GuardDashboard>', () => {
  it('should render component', () => {
    expect(renderTree(<GuardDashboard 
    />).toJSON()).toMatchSnapshot();
  });
  
});