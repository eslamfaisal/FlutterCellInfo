import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:cell_info/cell_info.dart';

void main() {
  const MethodChannel channel = MethodChannel('cell_info');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await CellInfo.platformVersion, '42');
  });
}
