import 'dart:async';

import 'package:flutter/services.dart';

class CellInfo {
  static const MethodChannel _channel = const MethodChannel('cell_info');

  static Future<String> get getCellInfo async {
    final String version = await _channel.invokeMethod('cell_info');
    return version;
  }
}
