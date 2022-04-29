import { View, Text, Button, TouchableOpacity, Alert } from "react-native";
import React from "react";
import styles from "../styles/Styles";

export default function Settings(props) {
  return (
    <View style={styles.screenContainer}>
      <TouchableOpacity
        onPress={() => Alert.alert("Setting #1", "This is setting #1")}
        style={styles.navigationButton}
      >
        <Text style={styles.navigationButtonText}>Setting #1</Text>
      </TouchableOpacity>
    </View>
  );
}
