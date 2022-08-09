package com.ptit.newspaper.api.res;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRes {
    String username;
    String address;
    String phoneNumber;
}
