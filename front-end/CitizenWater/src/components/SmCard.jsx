import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

export default function SmCard({cardStyle, children}) {
  return (
    <View style={[styles.card, cardStyle]}>
      {children}
    </View>
  )
}

const styles = StyleSheet.create({
    card: {
        backgroundColor: '#fff',
        flex: 1,
        margin: 10,
        padding: 5,
        borderRadius: 10,
        elevation: 3,
    },
})