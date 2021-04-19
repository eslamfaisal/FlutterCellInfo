
import 'dart:async';

import 'package:flutter/services.dart';

class CellInfo {
  static const MethodChannel _channel =
      const MethodChannel('cell_info');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
