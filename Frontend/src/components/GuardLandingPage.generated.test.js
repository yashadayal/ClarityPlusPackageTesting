import renderer from 'react-test-renderer';
import React from "react";
import GuardDashboard from './GuardDashboard';
import imgPath from "./Images/college.jpeg"
import GuardLandingPage from "./GuardLandingPage";

jest.mock("@mui/material");
jest.mock('./GuardDashboard');
jest.mock("./Images/college.jpeg");

const renderTree = tree => renderer.create(tree);
describe('<GuardLandingPage>', () => {
  it('should render component', () => {
    expect(renderTree(<GuardLandingPage 
    />).toJSON()).toMatchSnapshot();
  });
  
});