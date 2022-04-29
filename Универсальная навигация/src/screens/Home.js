import { View, Text, TouchableOpacity } from "react-native";
import React from "react";
import styles from "../styles/Styles";

export default function Home(props) {
  return (
    <View style={styles.screenContainer}>
      <Text style={styles.headerText}>Contacts App</Text>
      <TouchableOpacity
        onPress={() => props.navigation.navigate("Contacts")}
        style={styles.navigationButton}
      >
        <Text style={styles.navigationButtonText}>Contacts</Text>
      </TouchableOpacity>
    </View>
  );
}
