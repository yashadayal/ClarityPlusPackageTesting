// import renderer from 'react-test-renderer';
// import React , { useState } from 'react';
// import {  Button,TextField,FormControl,Box,Grid,} from '@mui/material';
// import { styled } from '@mui/material/styles';
// import Table from '@mui/material/Table';
// import TableBody from '@mui/material/TableBody';
// import TableCell, { tableCellClasses } from '@mui/material/TableCell';
// import TableContainer from '@mui/material/TableContainer';
// import TableHead from '@mui/material/TableHead';
// import TableRow from '@mui/material/TableRow';
// import Paper from '@mui/material/Paper';
import axios from 'axios';
// import { Alert, Collapse } from "@mui/material";
// import GuardDashboard from "./GuardDashboard";
// import GuardAddOrderPage from './GuardAddOrderPage';

jest.mock('@mui/material');
jest.mock('@mui/material/styles');
jest.mock('@mui/material/Table');
jest.mock('@mui/material/TableBody');
jest.mock('@mui/material/TableCell');
jest.mock('@mui/material/TableContainer');
jest.mock('@mui/material/TableHead');
jest.mock('@mui/material/TableRow');
jest.mock('@mui/material/Paper');
jest.mock('axios');
jest.mock("@mui/material");
jest.mock("./GuardAddOrderPage");

// const renderTree = tree => renderer.create(tree);
// describe('<GuardAddOrderPage>', () => {
//   it('should render component', () => {
//     expect(renderTree(<GuardAddOrderPage 
//     />).toJSON()).toMatchSnapshot();
//   });
  
// });

const setErrorMessage = jest.fn();
const setNullValueError = jest.fn();
const useStateMock = (initialState) => [initialState, jest.fn()]; // Mock useState

jest.mock('axios');

describe('createData function', () => {
  const originalDateNow = Date.now;

  beforeAll(() => {
    // Mock Date.now() to return a fixed date for testing purposes
    const DATE_TO_USE = new Date('2023-11-30T12:00:00Z');
    global.Date.now = jest.fn(() => DATE_TO_USE.getTime());
  });

  afterAll(() => {
    // Restore Date.now() to its original implementation
    global.Date.now = originalDateNow;
  });

  it('should create data object with valid inputs', () => {
    // Mock the input parameters
    const orderid = '123abc';
    const firstname = 'John';
    const lastname = 'Doe';
    const retailer = 'Retailer';

    // Execute the function
    const result = createData(orderid, firstname, lastname, retailer);

    // Assertions
    expect(setErrorMessage).not.toHaveBeenCalled();
    expect(setNullValueError).not.toHaveBeenCalled();
    expect(result).toEqual({
      OrderID: '123ABC',
      FirstName: 'John',
      LastName: 'Doe',
      DateOfDelivery: '2023-11-30',
      Retailer: 'Retailer',
    });
  });

  // Add more test cases for different scenarios if needed
});

