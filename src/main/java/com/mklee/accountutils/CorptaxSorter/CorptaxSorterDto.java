package com.mklee.accountutils.CorptaxSorter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CorptaxSorterDto {

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  static class simpleDto {
    String message;
    String success;
  }
}
