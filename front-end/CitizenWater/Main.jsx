import React, { useLayoutEffect } from 'react';
import { StyleSheet } from 'react-native';
import { Provider } from 'react-redux';
import { store } from './src/store/store';
import Login from './src/screens/Login';

const Main = () => {


    return (
        <Provider store={store}>
            <Login></Login>            
            
        </Provider>
    );
}

const styles = StyleSheet.create({})

export default Main;
