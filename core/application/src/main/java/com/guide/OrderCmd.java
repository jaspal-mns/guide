package com.guide;

public sealed interface OrderCmd {
   record OrderCreateCmd(String locationId, String customerId) implements OrderCmd {
   }

   record AddLineCmd(String productId, boolean isRecurring) implements OrderCmd {
   }
}
