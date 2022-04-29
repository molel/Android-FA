import { View, Text } from "react-native";
import React from "react";
import { Icon } from "react-native-elements";
import styles from "../styles/Styles";

export default function ContactListItem(props) {
  return (
    <View style={styles.contactListItemContainer}>
      <Icon name="user" type="antdesign" size={100} />
      <Text style={styles.contactListItemText}>{props.name}</Text>
    </View>
  );
}
