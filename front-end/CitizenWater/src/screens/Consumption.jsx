import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';

const Consumption = () => {
    return (
        <View style={generalStyle.view}>
            <Text style={styles.title}>Ma Conso</Text>
            <Text>Consommation mensuelle</Text>
            <Text>Consommation annuelle</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 15
    }
})

export default Consumption;
