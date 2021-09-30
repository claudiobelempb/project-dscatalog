import styled, { css } from 'styled-components';

export const LinkContainer = styled.a`
  ${({ theme }) => css`
    display: flex;
    align-items: center;
    color: ${theme.colors.white_100};
    font-size: 1rem;
    padding: 1rem;
    position: relative;
    text-transform: uppercase;
  `}
`;
