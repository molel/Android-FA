import { View, Text, TouchableOpacity } from "react-native";
import React from "react";
import { useNavigation } from "@react-navigation/native";
import styles from "../styles/Styles";

export default function HeaderButton(props) {
  const navigation = useNavigation();

  return (
    <TouchableOpacity onPress={() => navigation.navigate(props.screen)}>
      <Text style={styles.navigationButtonText}>{props.text}</Text>
    </TouchableOpacity>
  );
}
