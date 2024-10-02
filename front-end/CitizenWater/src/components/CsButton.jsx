import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'
import styleColors from '../styles/StyleColors'

export default function CsButton({text, style, onPress}) {
    return (
        <TouchableOpacity 
            style={[styles.btnStyle, style]}
            onPress={onPress}
        >
            <Text style={styles.btnContentStyle}>{text}</Text>
        </TouchableOpacity>
    )
}

const styles = StyleSheet.create({
    btnStyle: {
        backgroundColor: styleColors.blue3,
        padding: 10,
        borderRadius: 10
    },
    btnContentStyle : {
        fontSize: 25,
        fontWeight: '500',
        color: 'white',
        textAlign: 'center'
    },
})