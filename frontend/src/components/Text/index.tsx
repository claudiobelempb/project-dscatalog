import { TextP, TextSmall, TextStrong, TextSpan } from './styles';

type HeadingProps = {
  children?: string;
  target?: 'p' | 'small' | 'strong' | 'span';
  color?: string;
  uppercase?: boolean;
  mb?: string | number;
};

export const Text: React.FC<HeadingProps> = ({
  children,
  color = '',
  target = 'p',
  uppercase = false,
  mb = 2,
}) => {
  const renderText = () => {
    switch (target) {
      case 'p':
        return (
          <TextP
            mb={mb}
            iscolor={color}
            upcase={uppercase}
            className={`${target}`}
          >
            {children}
          </TextP>
        );
      case 'small':
        return (
          <TextSmall
            mb={mb}
            iscolor={color}
            upcase={uppercase}
            className={`${target}`}
          >
            {children}
          </TextSmall>
        );
      case 'span':
        return (
          <TextSpan
            mb={mb}
            iscolor={color}
            upcase={uppercase}
            className={`${target}`}
          >
            {children}
          </TextSpan>
        );
      case 'strong':
        return (
          <TextStrong
            mb={mb}
            iscolor={color}
            upcase={uppercase}
            className={`${target}`}
          >
            {children}
          </TextStrong>
        );
      default:
        return <p>header example</p>;
    }
  };

  return <div>{renderText()}</div>;
};
