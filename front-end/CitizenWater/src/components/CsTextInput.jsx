import { StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'
import styleColors from '../styles/StyleColors'

export default function CsTextInput({ label, value, placeholder, onChangeText, style, password }) {
    return (
        <View style={{...style, marginHorizontal: 5}}>
            <Text style={styles.labelStyle}>{label}</Text>
            <TextInput
                style={styles.inputStyle}
                value={value}
                placeholder={placeholder}
                onChangeText={onChangeText}
                secureTextEntry={password}
            />
        </View>
    )
}

const styles = StyleSheet.create({
    labelStyle: {
        fontSize: 25,
        fontWeight: '500',
        color: styleColors.blue4,
        margin: 5,

    },
    inputStyle: {
        borderWidth: 1,
        borderColor: styleColors.blue3,
        borderRadius: 10,
        paddingHorizontal: 20,
        fontSize: 20,
        textAlign: 'center'
    }
})